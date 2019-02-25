<%-- 
    Document   : welcome
    Created on : Jan 30, 2019, 3:08:11 PM
    Author     : shomonamukherjee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%= request.getAttribute("doctype")%><!--TODO: Clarify the reason for this-->


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project1Task2</title>
    </head>
    <body>
        <p>Give me a keyword, and I'll give you an interesting picture.</p>
        <form action="getButterfly" method="GET">

            <div class ="species">
                <label for="species">Type the species:</label>
                <input type="text" name="species" value="" style="border:1px solid black" /><br>
            </div>
            <br>
            <br>
            <div class ="region">
                <label>Select the region: </label><br>
                <select name="region">
                    <option value="All" name="region">All</option>
                    <option value="45172">Barbados</option>
                    <option value="45159">Belize</option>
                    <option value="45157">Bermuda</option>
                    <option value="45170">Bonaire</option>
                    <option value="45153">Canada</option>
                    <option value="45167">Cayman_Islands</option>
                    <option value="45156">Costa_Rica</option>
                    <option value="45155">Cuba</option>
                    <option value="45161">Dominican_Republic</option>
                    <option value="45160">El_Salvador</option>
                    <option value="45169">Guatemala</option>
                    <option value="45162">Haiti</option>
                    <option value="45165">Honduras</option>
                    <option value="45171">Jamaica</option>
                    <option value="45154">Mexico</option> 
                    <option value="45163">Nicaragua</option>
                    <option value="45158">Panama</option>
                    <option value="45166">Puerto_Rico</option>
                    <option value="45164">St._Kitts</option>
                    <option value="45168">The_Bahamas</option>
                    <option value="45152">United_States</option>              
                </select>

            </div>
            <br>
            <br>
            <div class = "stage">
                <label>Enter the stage: </label><br>
                <input type="radio" name="stage" value="All"checked> All<br>
                <input type="radio" name="stage" value="adult">adult<br>
                <input type="radio" name="stage" value="egg">egg<br>
                <input type="radio" name="stage" value="caterpillar">caterpillar<br>
                <input type="radio" name="stage" value="pupa">pupa<br>
            </div>
            <br>
            <br>

            <input type="submit" value="Submit" style="border:1px solid black" />
        </form>
        <br><br>
        <div>All images courtesy https://www.butterfliesandmoths.org </div>
    </body>
</html>
