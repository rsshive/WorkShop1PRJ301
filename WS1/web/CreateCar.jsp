<%-- 
    Document   : CreateCar
    Created on : Mar 14, 2025, 6:37:54 PM
    Author     : Lenovo
--%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Car</title>
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

<div class="container mt-4" style="max-width: 600px;">
    <h2>Add New Car</h2>

    <c:if test="${not empty message}">
        <div class="alert alert-info">
            ${message}
        </div>
    </c:if>
    
    <form action="CreateController" method="post">
        <div class="mb-3">
            <label class="form-label">CarName</label>
            <input type="text" class="form-control" name="txtCarName" required />
        </div>
        
        <div class="mb-3">
            <label class="form-label">Manufacturer</label>
            <input type="text" class="form-control" name="txtManufacturer" required />
        </div>
        
        <div class="mb-3">
            <label class="form-label">Price</label>
            <input type="number" step="0.01" class="form-control" name="txtPrice" required />
        </div>
        
        <div class="mb-3">
            <label class="form-label">ReleasedYear</label>
            <input type="number" class="form-control" name="txtReleasedYear" required />
        </div>
        
        <button type="submit" class="btn btn-primary">Create</button>
        <a class="btn btn-link" href="ListController">Back to List</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
