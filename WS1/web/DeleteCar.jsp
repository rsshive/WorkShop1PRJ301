<%-- 
    Document   : CarDetails
    Created on : Mar 10, 2025, 12:21:32 AM
    Author     : Lenovo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.DTO.Car"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Car</title>
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
        <li class="nav-item"><a class="nav-link" href="ListController">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Privacy</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container mt-4">
    <h2>Delete</h2>
    <p>Are you sure you want to delete this?</p>
    <p><b>Car</b></p>
    
    <table class="table" style="max-width: 400px;">
        <tr><td><strong>CarId</strong></td><td>${carToDelete.carId}</td></tr>
        <tr><td><strong>CarName</strong></td><td>${carToDelete.carName}</td></tr>
        <tr><td><strong>Manufacturer</strong></td><td>${carToDelete.manufacturer}</td></tr>
        <tr><td><strong>Price</strong></td><td>${carToDelete.price}</td></tr>
        <tr><td><strong>ReleasedYear</strong></td><td>${carToDelete.releasedYear}</td></tr>
    </table>
    

    <form action="DeleteController" method="post">
        <input type="hidden" name="action" value="delete"/>
        <input type="hidden" name="carId" value="${carToDelete.carId}"/>
        <button type="submit" class="btn btn-danger">Delete</button>
        <a class="btn btn-link" href="MainController">Back to List</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
