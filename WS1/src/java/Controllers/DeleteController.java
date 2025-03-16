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
@WebServlet(name = "DeleteController", urlPatterns = {"/DeleteController"})
public class DeleteController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String confirmDeletePage = "DeleteCar.jsp"; // Trang xác nhận

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String carIdStr = request.getParameter("carId");
        String message = null;
        String url = "ListController"; // Sau khi xóa xong, sẽ quay về trang danh sách

        try {
            CarDao carDao = new CarDao();

            if ("confirm".equals(action)) {
                // Bước 1: Hiển thị trang xác nhận xóa
                Car car = carDao.getDetails(carIdStr);
                if (car != null) {
                    request.setAttribute("carToDelete", car);
                    // Forward sang trang DeleteCar.jsp để hiển thị chi tiết
                    RequestDispatcher rd = request.getRequestDispatcher(confirmDeletePage);
                    rd.forward(request, response);
                    return; // Dừng luôn, không chạy xuống dưới
                }
            } else if ("delete".equals(action)) {
                // Bước 2: Thực hiện xóa
                if (carDao.deleteCar(carIdStr)) {
                    message = "<b style='color: green'>Car deleted successfully.</b>";
                } else {
                    message = "<b style='color: red'>Failed to delete the car.</b>";
                }
            }

        } catch (Exception ex) {
            message = "<b style='color: red'>Error: " + ex.getMessage() + "</b>";
            ex.printStackTrace();
        } finally {
            // Dù thành công hay lỗi thì quay về trang danh sách
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
            throws ServletException, IOException {
        processRequest(request, response);
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
