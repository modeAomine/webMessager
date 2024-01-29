$(document).ready(function () {
    const sessionLogin = /*[[${userLogin}]]*/ "";
    $("#userLogin").text(sessionLogin);
});

function updateSettings() {
    const newLogin = $("#newLogin").val();
    const newPassword = $("#newPassword").val();
    const newAvatar = $("#newAvatar")[0].files[0];
    $("#settingsModal").modal("hide");
    Swal.fire({
        icon: 'success',
        title: 'Настройки обновлены успешно!',
        showConfirmButton: false,
        timer: 1800
    });
}