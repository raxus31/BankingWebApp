<!doctype html>
<html>
	<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body class="bg-secondary">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <!-- Image and text -->
  <a class="navbar-brand" href="about.html">
    <img src="images/raxus.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
    Raxus
  </a>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="transaction">Transactions</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pay</a>
      </li>
	  <li class="nav-item">
        <div class="dropdown">
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			Services
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			<a class="dropdown-item" href="errorPage.jsp">Savings Account</a>
			<a class="dropdown-item" href="errorPage.jsp">Recurring Deposit Account</a>
			<a class="dropdown-item" href="errorPage.jsp">Fixed Deposit account</a>
			<a class="dropdown-item" href="errorPage.jsp">Money Market Account</a>
			<a class="dropdown-item" href="errorPage.jsp">Credit Card</a>
			<a class="dropdown-item" href="errorPage.jsp">Debit Card</a>
			<a class="dropdown-item" href="errorPage.jsp">Mutual Funds</a>
		  </div>
		</div>
      </li>
      <li class="nav-item">
		<a class="nav-link" href="Loan.html">Loan's Available</a>
      </li>
    </ul>
  </div> 
 	 <div class="row navbar-brand">
 	 	<div class="col"><p class="text-white navbar-brand">${accountNumber}</p></div>
    	<div class="col"><img src="images/${profileImage}" width="30" height="30" class="d-inline-block align-top" alt="profileimage"/></div>
 	 </div>
</nav>

<div class="container mt-5 h-75 w-50">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
     <div class="carousel-indicators">
    <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="carousel-item active">
        <img src="images/bank1.jpg" alt="NetBanking" style="width:100%">
        <div class="carousel-caption">
          <h3>Net Banking</h3>
          <p>Net Banking is always so much fun!</p>
        </div>
      </div>

      <div class="carousel-item">
        <img src="images/bank2.jpeg" alt="CreditCard" style="width:100%">
        <div class="carousel-caption">
          <h3>Credit Cards</h3>
          <p>Credit Cards!</p>
        </div>
      </div>
	   <div class="carousel-item">
        <img src="images/bank3.jpg" alt="PersonalAssistant" style="width:100%">
        <div class="carousel-caption">
          <h3>Personal Assistant</h3>
          <p>We love Personal Assistant!</p>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control-prev" href="#myCarousel" data-slide="prev">
       <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </a>
    <a class="right carousel-control-next" href="#myCarousel" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </a>
  </div>
</div>


  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<!-- Always remember to call the above files first before calling the bootstrap.min.js file -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
	</body>
</html>
