/*
 *All images courtesy https://www.butterfliesandmoths.org.
 */
package ButterflySearch;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shomonamukherjee
 */
@WebServlet(name = "ButterflySearchServlet",
        urlPatterns = {"/getButterfly"})
public class ButterflySearchServlet extends HttpServlet {

    ButterflySearchModel bm = null;

    // Initiate this servlet by instantiating the model that it will use.
    @Override
    public void init() {
        bm = new ButterflySearchModel();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // This servlet will reply to HTTP GET requests via this doGet method
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // get the search parameter
        String species = request.getParameter("species");
        String region = request.getParameter("region");
        String stage = request.getParameter("stage");

        // determine what type of device our user is
        String ua = request.getHeader("User-Agent");

        boolean mobile;
        // prepare the appropriate DOCTYPE for the view pages
        if (ua != null && ((ua.indexOf("Android") != -1) || (ua.indexOf("iPhone") != -1))) {
            mobile = true;
            request.setAttribute("doctype", "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.2//EN\" \"http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd\">");
        } else {
            mobile = false;
            request.setAttribute("doctype", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        }

        String nextView;
        /*
         * Check if the search parameter is present.
         * If not, then show the welcome page.
         */
        if (species != null) {
            String picSize = (mobile) ? "mobile" : "desktop";
            // use model to do the search and choose the result viewl
            String pictureURL = bm.doButterflySearch(species, region, stage, picSize);

            if (pictureURL != null) {
                request.setAttribute("noImage", "");
                request.setAttribute("pictureURL", pictureURL);

            } else {
                request.setAttribute("noImage", "No images found at this momemt!");
                request.setAttribute("pictureURL", "");

            }
            nextView = "results.jsp";

        } else {
            // no search parameter so choose the prompt view
            nextView = "welcome.jsp";
        }
        // Transfer control over the the correct "view"
        RequestDispatcher view = request.getRequestDispatcher(nextView);
        view.forward(request, response);
    }

}
