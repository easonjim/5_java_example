<%! 
   int pageCount = 0;
   void addCount() {
      pageCount++;
   }
%>

<% addCount(); %>

<html>
   <head>
      <title>The include Directive Example</title>
   </head>
   
   <body>
      <center>
         <h2>The include Directive Example</h2>
         <p>This site has been visited <%= pageCount %> times.</p>
      </center>
      <br/><br/>