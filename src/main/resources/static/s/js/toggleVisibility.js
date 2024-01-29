function toggleVisibility() {
    fetch('/toggleVisibility', {
        method: 'POST',
        credentials: 'same-origin',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            if (data === 'success') {
                // Обновление видимости дополнительной информации
                const additionalInfo = document.getElementById('additionalInfo');
                additionalInfo.style.display = additionalInfo.style.display === 'none' ? 'block' : 'none';
            } else {
                console.error('Ошибка при переключении видимости');
            }
        })
        .catch(error => {
            console.error('Ошибка при выполнении запроса:', error);
        });
}