<%@ page import="fizzbuzz.FizzBuzzer" %>
<html>
<body>
<h2>Fizz Buzz Table</h2>
<table>
    <thead>
        <tr>
            <td> Number </td> <td> Fizz Buzz</td>
        </tr>
    </thead>
    <tbody>
    <% FizzBuzzer fizzBuzzer = new FizzBuzzer();%>
    <% for (int i=1;i<101;i++) {%>

        <tr>
            <td><a href="services/fizzbuzz/<%=i%>"><%=i%></a></td><td><%=fizzBuzzer.fizzBuzzer(i)%></td>
        </tr>

    <%}%>
    </tbody>

</table>

<table id="cars-app">
    <thead>
        <tr>
            <td>Id</td>
            <td>plate</td>
            <td>brand</td>
            <td>model</td>
            <td>year</td>
        </tr>
    </thead>
    <tbody id="cars-app-body">

    </tbody>
    <tfoot>
        <tr>
            <td>Id</td>
            <td>plate</td>
            <td>brand</td>
            <td>model</td>
            <td>year</td>
        </tr>
    </tfoot>
</table>
<script src="js/app.js"></script>
</body>
</html>
