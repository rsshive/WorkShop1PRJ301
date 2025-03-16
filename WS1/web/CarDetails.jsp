<%-- 
    Document   : CarDetails
    Created on : Mar 10, 2025, 12:12:32 AM
    Author     : Lenovo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.DTO.Car"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Car Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">AutomobileWebApp</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link" href="SearchCarController">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Privacy</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container mt-4">
    <h2>Car Details</h2>
    
    <c:if test="${not empty message}">
        <div class="alert alert-info">
            ${message}
        </div>
    </c:if>
    
    <div class="card" style="max-width: 400px;">
        <div class="card-body">
            <h5 class="card-title">Car</h5>
            <p><strong>CarId:</strong> ${carDetails.carId}</p>
            <p><strong>CarName:</strong> ${carDetails.carName}</p>
            <p><strong>Manufacturer:</strong> ${carDetails.manufacturer}</p>
            <p><strong>Price:</strong> ${carDetails.price}</p>
            <p><strong>ReleasedYear:</strong> ${carDetails.releasedYear}</p>
            
            <a class="btn btn-secondary" href="UpdateCar.jsp?carId=${carDetails.carId}">Edit</a>
            <a class="btn btn-link" href="ListController">Back to List</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
