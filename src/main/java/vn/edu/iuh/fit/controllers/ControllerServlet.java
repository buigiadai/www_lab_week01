package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.GrantAccess;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.GrantAccessRepository;
import vn.edu.iuh.fit.repositories.RoleRepository;

import java.io.IOException;

@WebServlet(name = "ControlServlet", urlPatterns = {"/ControlServlet"})
public class ControllerServlet extends HttpServlet {
    private final AccountRepository accountRepository = new AccountRepository();
    private final GrantAccessRepository grantAccessRepository = new GrantAccessRepository();

    private final RoleRepository roleRepository = new RoleRepository();
    private GrantAccess grantAccess;
    //    private final LogsRepository logsRepository ;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("txt/html");
//        //Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</html></body>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Có");
        String action = req.getParameter("action");
        resp.setContentType("text/html");

        if ("login".equals(action)) {
            String email = req.getParameter("userEmail");
            String pass = req.getParameter("userPassword");
            Account account = accountRepository.checkLogin(email, pass);
            if (account != null) {
                //lấy thông tin user
                this.grantAccess = grantAccessRepository.getGrantAccess(account.getAccountId());
                GrantAccess grantAccess = this.grantAccess;
                req.setAttribute("grantAccess", grantAccess);
                req.setAttribute("account", account);

                if (grantAccess.getRoleId().equalsIgnoreCase("user")) {
                    resp.sendRedirect("info.jsp");
//                    hiển thị thông tin csủa người đăng nhập cùng các quyền mà người đó có

                } else if (grantAccess.getRoleId().equalsIgnoreCase("admin")) {
//                    hiển thị trang dashboard cho phép quản lý các account khác (bao gồm các quyền thêm, xóa, sửa và cấp quyền)
                    req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
                }
            } else {
                //Hiển thị thông báo đăng nhập ko thành công
            }
        }
    }

    //    void showInformation()
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
