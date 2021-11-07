<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body>
<div class="container mt-2 text-center">
	<h1>Transactions</h1>
	<table class="table table-hover">
		  <thead>
		    <tr class="table-dark">
		      <th scope="col">#</th>
		      <th scope="col">From</th>
		      <th scope="col">To</th>
		      <th scope="col">Amount</th>
		      <th scope="col">Date</th>
		    </tr>
		  </thead>
		  <tbody>
		  		<c:forEach items="${transactions}" var="t">
		  			<tr>
		  				<th>${t.srNo}</th>
		  				<td>${t.from}</td>
		  				<td>${t.to}</td>
		  				<td>${t.amount}</td>
		  				<td>${t.dateOfTransaction}</td>
		  			</tr>
		  		</c:forEach>
		  </tbody>
	</table>
</div>

	</body>
</html>