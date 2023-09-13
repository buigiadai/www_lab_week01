<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">

<html>

<head>
    <title>Đăng nhập</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<!-- Trang đăng nhập -->
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 ">
            <div class="card border-info">
                <header class="card-header">
                    <h4 class="card-title mt-2 text-center">Đăng nhập</h4>
                </header>
                <article class="card-body">
                    <form action="ControlServlet" method="post">
                        <div class="form-group">
                            <label for="userEmail">Email</label>
                            <input type="email" class="form-control text-center" id="userEmail" aria-describedby="emailHelp"
                                   placeholder="Email">
                        </div>
                        <div class="form-group">
                            <label for="userPassword">Mật khẩu</label>
                            <input type="password"  class="form-control text-center" id="userPassword"
                                   placeholder="Mật khẩu">
                        </div>
                        <div class="form-group">
                            <!-- đăng nhập -->
                            <button type="submit" class="btn btn-primary btn-block font-weight-bold"> ĐĂNG NHẬP</button>
                            <!-- đang ký tài khoản mới  -->
                            <a href="register.html" class="btn btn-success btn-block font-weight-bold">ĐĂNG KÝ TÀI KHOẢN
                                MỚI</a>
                        </div>
                    </form>
                </article>
            </div>
        </div>
    </div>
</div>

</body>

</html>