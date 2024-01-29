function editProfile() {
    // Заполнение полей формы текущими значениями
    document.getElementById('newName').value = "${user.name}";
    document.getElementById('newEmail').value = "${user.email}";
    document.getElementById('newDiscord').value = "${user.discord}";

    // Отображение формы редактирования
    document.getElementById('editProfileForm').style.display = 'block';
}

function saveChanges() {
    // Отправка формы на сервер для сохранения изменений
    document.getElementById('editProfileForm').submit();
}