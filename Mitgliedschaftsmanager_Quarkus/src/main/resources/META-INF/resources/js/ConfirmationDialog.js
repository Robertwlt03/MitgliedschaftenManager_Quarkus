const openDialog = document.querySelectorAll('.open-dialog')
const closeDialog = document.querySelectorAll('.close-dialog')
const deleteDialog= document.querySelector('#delete-dialog')

let memberName= document.querySelectorAll('.delete-member-name')
let memberId= document.querySelector('.delete-member-id')

openDialog.forEach(btn => {
    btn.addEventListener('click', openBtnDialog)
});

closeDialog.forEach(btn => {
    btn.addEventListener('click', closeBtnDialog)
});

function openBtnDialog (event) {
    deleteDialog.showModal();

    const clickedBtn = event.target.closest('button')

    const memberNameValue = clickedBtn.dataset.name;
    const memberIdValue = clickedBtn.dataset.id;

    memberName.forEach(name => {name.textContent = memberNameValue;});
    memberId.href = memberId.href + memberIdValue
}

function closeBtnDialog () {
    deleteDialog.close();
}


