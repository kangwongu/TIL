<%@ page contentType="text/html;charset=utf-8"%>

<html>  
<head>   
	<title>표현 언어에서 사용되는 데이터들</title>   
</head>  
<body>   
	<h1>여러 가지 논리 연산자</h1>
	<h1>
	  \${(10==10) && (20==20)}: ${(10==10) && (20==20)}<br>
	  \${(10==10) and (20==20)}: ${(10==10) and (20==20)}<br><br>

	  \${(10==10) || (20==2)}: ${(10==10) || (20==2)}<br>	  
	  \${(10==10) or (20==2)}: ${(10==10) or (20==2)}<br><br>	  
	 
	  \${!(10==10)}: ${!(10==10)}<br>	  
	  \${not(10==10)}: ${!(10==10)}<br>	  
	 
	</h1>
</body>
</html>