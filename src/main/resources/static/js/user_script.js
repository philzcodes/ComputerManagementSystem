document.addEventListener("DOMContentLoaded", function () {
  const addUserBtn = document.getElementById("addUserBtn");
  const userModal = document.getElementById("userModal");
  const closeModalBtn = document.getElementsByClassName("close")[0];
  const userForm = document.getElementById("userForm");
  const modalTitle = document.getElementById("modalTitle");

  // Open modal to add user
  addUserBtn.onclick = function () {
    userModal.style.display = "block";
    modalTitle.textContent = "Add User";
    userForm.reset(); // Clear form fields
    userForm.action = "/users/add";  // Set action for adding user
  };

  // Close modal
  closeModalBtn.onclick = function () {
    userModal.style.display = "none";
  };

  // Close modal when clicking outside of it
  window.onclick = function (event) {
    if (event.target === userModal) {
      userModal.style.display = "none";
    }
  };

  // Handle form submission (for adding or editing user)
  userForm.onsubmit = function (event) {
    event.preventDefault();
    fetch(userForm.action, {
      method: "POST",
      body: new FormData(userForm),
    })
    .then(response => response.json())
    .then(data => {
      alert("User saved successfully!");
      userModal.style.display = "none";
      window.location.reload();  // Reload the page to update the user table
    });
  };
});

// Edit user function
function editUser(id) {
  fetch(`/users/edit/${id}`)
    .then(response => response.json())
    .then(user => {
      const userModal = document.getElementById("userModal");
      const modalTitle = document.getElementById("modalTitle");
      const userForm = document.getElementById("userForm");

      userModal.style.display = "block";
      modalTitle.textContent = "Edit User";
      
      userForm.userName.value = user.name;
      userForm.userEmail.value = user.email;
      userForm.userRole.value = user.role;
      userForm.action = `/users/edit/${id}`;  // Set action for editing user
    });
}

// Delete user function
function deleteUser(id) {
  if (confirm("Are you sure you want to delete this user?")) {
    fetch(`/users/delete/${id}`, {
      method: "DELETE"
    })
    .then(response => {
      if (response.ok) {
        alert("User deleted successfully!");
        window.location.reload();  // Reload the page after deletion
      } else {
        alert("Failed to delete user.");
      }
    });
  }
}
