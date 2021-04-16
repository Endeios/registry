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
</body>
</html>
