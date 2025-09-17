<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background: #fff;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px #ccc;
            width: 350px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
            display: flex;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"],
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-top: 5px;
        }

        .inline-group {
            display: flex;
            gap: 10px;
        }

        .radio-group {
            margin-top: 10px;
        }

        .radio-group input {
            margin-right: 5px;
        }

        .btn {
            width: 100%;
            padding: 12px;
            background: #1877f2;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        .btn:hover {
            background: #145db2;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>User Registration Form</h2>
    <form action="users" method="post">
        <!-- First & Last name -->
        <div class="inline-group" style="margin-bottom: 10px">
            <input type="text" name="firstName" placeholder="First Name" required>
            <input type="text" name="lastName" placeholder="Last Name" required>
        </div>

        <!-- Email -->
        <div class="form-group">
            <input type="email" name="email" placeholder="Your Email" required>
        </div>
        <div class="form-group">
            <input type="email" name="confirmEmail" placeholder="Re-enter Email" required>
        </div>

        <!-- Password -->
        <div class="form-group">
            <input type="password" name="password" placeholder="New Password" required>
        </div>

        <!-- Birthday -->
        <div>
            <label>Birthday</label><br>
            <div class="inline-group">
                <select name="month" required>
                    <option value="">Month</option>
                    <% for (int i = 1; i <= 12; i++) {%>
                    <option><%= i %></option>
                    <% } %>
                </select>
                <select name="day" required>
                    <option value="">Day</option>
                    <% for (int i = 1; i <= 31; i++) { %>
                    <option><%= i %></option>
                    <% } %>
                </select>
                <select name="year" required>
                    <option value="">Year</option>
                    <% for (int i = 2025; i >= 1900; i--) { %>
                    <option><%= i %></option>
                    <% } %>
                </select>
            </div>
        </div>

        <!-- Gender -->
        <div class="radio-group">
            <label><input type="radio" name="gender" value="Female" required> Female</label>
            <label><input type="radio" name="gender" value="Male" required> Male</label>
        </div>

        <!-- Submit -->
        <div class="form-group" style="margin-top: 10px">
            <button type="submit" class="btn">Sign Up</button>
        </div>
    </form>
</div>
</body>
</html>
