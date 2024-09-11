// script.js
document.addEventListener("DOMContentLoaded", function () {
  const addInventoryBtn = document.getElementById("addInventoryBtn");
  const inventoryModal = document.getElementById("inventoryModal");
  const closeModalBtn = document.getElementsByClassName("close")[0];
  const inventoryForm = document.getElementById("inventoryForm");
  const modalTitle = document.getElementById("modalTitle");

  // Function to open modal
  addInventoryBtn.onclick = function () {
    inventoryModal.style.display = "block";
    modalTitle.textContent = "Add Inventory Item";
    inventoryForm.reset(); // Clear the form fields
  };

  // Function to close modal
  closeModalBtn.onclick = function () {
    inventoryModal.style.display = "none";
  };

  // Close modal when clicking outside of it
  window.onclick = function (event) {
    if (event.target === inventoryModal) {
      inventoryModal.style.display = "none";
    }
  };

  // Handle form submission
  inventoryForm.onsubmit = function (event) {
    event.preventDefault();
    // Logic to save inventory item data (e.g., via API call)
    alert("Inventory item saved successfully!");
    inventoryModal.style.display = "none";

    // Optionally, add the new item to the table dynamically
    const partName = document.getElementById("partName").value;
    const quantity = document.getElementById("quantity").value;
    const location = document.getElementById("location").value;

    const tableBody = document.getElementById("inventoryTableBody");
    const newRow = document.createElement("tr");
    newRow.innerHTML = `
            <td>${Math.floor(Math.random() * 1000)}</td>
            <td>${partName}</td>
            <td>${quantity}</td>
            <td>${location}</td>
            <td class="actions-btn">
                <button class="edit-btn" onclick="editInventory(this)">Edit</button>
                <button class="delete-btn" onclick="deleteInventory(this)">Delete</button>
            </td>
        `;
    tableBody.appendChild(newRow);

    // Example: Check stock levels and add a stock alert if needed
    if (quantity <= 5) {
      const stockAlertsList = document.getElementById("stockAlertsList");
      const newAlert = document.createElement("li");
      newAlert.className = "alert-item critical";
      newAlert.textContent = `${partName}: Stock low (${quantity} units remaining).`;
      stockAlertsList.appendChild(newAlert);
    }
  };
});

// Edit inventory function
function editInventory(button) {
  const row = button.parentNode.parentNode;
  const partName = row.cells[1].innerText;
  const quantity = row.cells[2].innerText;
  const location = row.cells[3].innerText;

  const inventoryModal = document.getElementById("inventoryModal");
  const modalTitle = document.getElementById("modalTitle");
  const inventoryForm = document.getElementById("inventoryForm");

  inventoryModal.style.display = "block";
  modalTitle.textContent = "Edit Inventory Item";

  inventoryForm.partName.value = partName;
  inventoryForm.quantity.value = quantity;
  inventoryForm.location.value = location;
}

// Delete inventory function
function deleteInventory(button) {
  const row = button.parentNode.parentNode;
  row.parentNode.removeChild(row);
  alert("Inventory item deleted successfully!");
}
