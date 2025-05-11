function login() {
    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();
    console.log(username);
    console.log(password);
    const validAccounts = [
        { username: "admin", password: "123456" }
    ];
    console.log(validAccounts[0].username);
    console.log(validAccounts[0].password);
    if (!username || !password) {
        document.getElementById("errorMessage").textContent = "Vui lòng nhập đầy đủ email và mật khẩu.";
        return;
    }

    if (username == validAccounts[0].username && password == validAccounts[0].password) {
        alert("Đăng nhập thành công!");
        window.location.href = "/";
    } else {
        document.getElementById("errorMessage").textContent = "Email hoặc mật khẩu không đúng.";
    }

}
