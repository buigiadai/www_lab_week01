<!DOCTYPE html>
<html lang="vi">

<head>
    <title>Thông tin cá nhân</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles.css">
</head>

<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h3 class="mb-0 text-center">THÔNG TIN CÁ NHÂN</h3>
            </div>
            <div class="card-body">
                <form>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="userId">User Id:</label>
                            <input type="text" class="form-control" id="userId" readonly value="01234567">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="username">Username:</label>
                            <input type="text" class="form-control" id="username" readonly value="John Doe">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="inputEmail">Email:</label>
                            <input type="email" class="form-control" id="inputEmail" readonly
                                value="johndoe@example.com">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="inputPhone">Phone:</label>
                            <input type="tel" class="form-control" id="inputPhone" readonly value="+1 234 567 890">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="inputRole">Role:</label>
                            <input type="text" class="form-control" id="inputRole" readonly value="Administrator">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="inputPassword">Password:</label>
                            <input type="password" class="form-control" readonly id="inputPassword" value="password">
                            <div class="mt-1">
                                <button type="button" class="btn btn-primary">Đổi mật khẩu</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

        </div>
        <div class="card-footer text-center">
            <button type="button" class="btn btn-secondary btn-danger font-weight-bold ">ĐĂNG
                XUẤT</button>
        </div>
    </div>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>