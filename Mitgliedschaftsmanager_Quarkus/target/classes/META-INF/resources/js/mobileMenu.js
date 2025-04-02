const menuToggle = document.querySelector('.menu-toggle');
const navbarLinksWrapper = document.querySelector('.navbar-links-wrapper');
const searchForm = document.querySelector('.search-form');

menuToggle.addEventListener('click', () => {
    toggleVisibility(navbarLinksWrapper)
    toggleVisibility(searchForm)
});

function toggleVisibility(element) {
    if (element.style.display === 'none' || getComputedStyle(element).display === 'none') {
        element.style.display = 'flex';
    } else {
        element.style.removeProperty('display');
    }
}