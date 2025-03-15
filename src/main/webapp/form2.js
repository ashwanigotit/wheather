/**
 * 
 */

const form = document.querySelector(".form2");
const load = document.querySelector(".load");
const button = document.querySelector(".but");

function showloading() {
    button.style.display = "none";
    load.style.display = "block";
}

function hideloading() {
    button.style.display = "block";
    load.style.display = "none";
}

form.addEventListener("submit", (event) => {
    event.preventDefault();

    showloading();

    setTimeout(() => {
        hideloading();
    }, 2000);

    const formData = new FormData(form);

    fetch("Servlet", {
        method: "post",
        body: formData,
    })
        .then((data) => data.text())
        .then((data) => {
            console.log("response", data); // Fixed typo
        })
        .catch((error) => {
            console.error("failed", error);
        });
});
