<%-- 
    Document   : CarDetails
    Created on : Mar 10, 2025, 12:21:36 AM
    Author     : Lenovo
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Car List</title>
    <!-- Bootstrap 5 CSS (CDN) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">AutomobileWebApp</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Privacy</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container mt-4">
        <h1>Car List</h1>
        

        <div class="mb-3">
            <a class="btn btn-primary" href="CreateCar.jsp">Create New</a>
        </div>
        

        <c:if test="${not empty message}">
            <div class="alert alert-info">
                ${message}
            </div>
        </c:if>

        <table class="table table-bordered table-hover align-middle">
            <thead class="table-light">
                <tr>
                    <th>CarId</th>
                    <th>CarName</th>
                    <th>Manufacturer</th>
                    <th>Price</th>
                    <th>ReleasedYear</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="car" items="${ListCar}">
                    <tr>
                        <td>${car.carId}</td>
                        <td>${car.carName}</td>
                        <td>${car.manufacturer}</td>
                        <td>${car.price}</td>
                        <td>${car.releasedYear}</td>
                        <td>
                            <a class="btn btn-sm btn-secondary" href="UpdateController?carId=${car.carId}">Edit</a>
                            <a class="btn btn-sm btn-info" href="DetailsController?carId=${car.carId}">Details</a>
                            <a class="btn btn-sm btn-danger"
                               href="DeleteController?action=confirm&carId=${car.carId}">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    
    <!-- Bootstrap 5 JS (CDN) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
