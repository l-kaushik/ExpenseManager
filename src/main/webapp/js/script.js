function loadSection(page){
    fetch('dashboard?page=' + page)
        .then(response => response.text())
        .then(html => {
            document.getElementById('main-section').innerHTML = html;
        })
        .catch(err => console.error('Error loading section:', err));
}