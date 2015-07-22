package org.supermarketdiscount.action;

import net.sourceforge.stripes.util.StringUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * A simplistic security filter for Bugzooky that ensures that the user is logged in
 * before allowing access to any secured pages.
 *
 * @author Tim Fennell
 */
public class SecurityFilter implements Filter {
    private static Set<String> publicUrls = new HashSet<String>();

    static {
        publicUrls.add("/jsp/login.jsp");
        publicUrls.add("/quickstart/index.jsp");
//        publicUrls.add("/bugzooky/Register.jsp");
//        publicUrls.add("/bugzooky/Exit.jsp");
        publicUrls.add("/Login.action");
//        publicUrls.add("/examples/bugzooky/Register.action");
//        publicUrls.add("/examples/bugzooky/ViewResource.action");
    }

    /**
     * Does nothing.
     */
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getSession().getAttribute("admin") != null) {
            filterChain.doFilter(request, response);
        } else if (isPublicResource(request)) {
            filterChain.doFilter(request, response);
        } else {
            // Redirect the user to the login page, noting where they were coming from
            String targetUrl = StringUtil.urlEncode(request.getServletPath());

            response.sendRedirect(
                    request.getContextPath() + "/jsp/login.jsp?targetUrl=" + targetUrl);
        }
    }

    /**
     * Method that checks the request to see if it is for a publicly accessible resource
     */
    protected boolean isPublicResource(HttpServletRequest request) {
        String resource = request.getServletPath();

        return publicUrls.contains(request.getServletPath())
                || (!resource.endsWith(".jsp") && !resource.endsWith(".action"));
    }

    /**
     * Does nothing.
     */
    public void destroy() {
    }
}
