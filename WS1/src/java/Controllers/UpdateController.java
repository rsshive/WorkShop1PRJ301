/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.DAO.CarDao;
import Models.DTO.Car;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String updateCarPage = "UpdateCar.jsp";
    private final String detailsPage = "DetailsController"; // Sau khi cập nhật, chuyển về trang chi tiết

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String carIdStr = request.getParameter("txtCarId");
        String carName = request.getParameter("txtCarName");
        String manufacturer = request.getParameter("txtManufacturer");
        String priceStr = request.getParameter("txtPrice");
        String releasedYearStr = request.getParameter("txtReleasedYear");
        String message = null;
        String url = updateCarPage;
        
        if (carIdStr == null || carIdStr.isEmpty()) {
            // Handle the error appropriately: set a default value or return an error message
            throw new ServletException("Car ID is missing or empty.");
        }
        int carId = Integer.parseInt(carIdStr);
  
        try {

            double price = Double.parseDouble(priceStr);
            int releasedYear = Integer.parseInt(releasedYearStr);

            Car car = new Car();
            car.setCarId(String.valueOf(carId));
            car.setCarName(carName);
            car.setManufacturer(manufacturer);
            car.setPrice(price);
            car.setReleasedYear(releasedYear);

            CarDao carDao = new CarDao();
            
            if (carDao.updateCar(car)) {
                message = "<b style='color: green'>Car updated successfully.</b>";
                url = detailsPage + "?carId=" + carId;
            } else {
                message = "<b style='color: red'>Failed to update the car.</b>";
            }
        } catch (Exception ex) {
            message = "<b style='color: red'>Error: " + ex.getMessage() + "</b>";
            url = updateCarPage + "?carId=" + carId;
            ex.printStackTrace();
        } finally {
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
        {
        try {
            String carIdStr = request.getParameter("carId");
            CarDao dao = new CarDao();
            Car car = dao.getDetails(carIdStr);
            request.setAttribute("carDetails", car);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        request.getRequestDispatcher("UpdateCar.jsp").forward(request, response);
    }
        
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
