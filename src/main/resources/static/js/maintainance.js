document.addEventListener("DOMContentLoaded", function () {
  const calendarEl = document.getElementById("calendar");
  const calendar = new FullCalendar.Calendar(calendarEl, {
    initialView: "dayGridMonth",
    headerToolbar: {
      left: "prev,next today",
      center: "title",
      right: "dayGridMonth,timeGridWeek,timeGridDay",
    },
    events: '/maintenance/events', // Fetch events from the Spring Boot API
    eventClick: function (info) {
      alert(
        "Task: " +
          info.event.title +
          "\nAssigned to: " +
          info.event.extendedProps.assignedTo
      );
    },
  });

  calendar.render();

  const addScheduleBtn = document.getElementById("addScheduleBtn");
  const scheduleModal = document.getElementById("scheduleModal");
  const closeModalBtn = document.getElementsByClassName("close")[0];
  const scheduleForm = document.getElementById("scheduleForm");
  const modalTitle = document.getElementById("modalTitle");

  // Function to open the modal
  addScheduleBtn.onclick = function () {
	alert("hello");
    scheduleModal.style.display = "block";
    modalTitle.textContent = "Add Maintenance Task";
    scheduleForm.reset(); // Clear the form fields
  };

  // Function to close the modal
  closeModalBtn.onclick = function () {
    scheduleModal.style.display = "none";
  };

  // Close the modal when clicking outside of it
  window.onclick = function (event) {
    if (event.target === scheduleModal) {
      scheduleModal.style.display = "none";
    }
  };

  // Handle form submission
  scheduleForm.onsubmit = function (event) {
    event.preventDefault();
    const formData = new FormData(scheduleForm);
    
    fetch(scheduleForm.action, {
      method: 'POST',
      body: formData
    })
    .then(response => response.json())
    .then(data => {
      alert("Maintenance task saved successfully!");
      scheduleModal.style.display = "none";

      // Add the new event to the calendar dynamically
      calendar.addEvent({
        title: data.taskName,
        start: data.taskDate,
        end: data.taskDate,
        extendedProps: {
          equipment: data.equipment,
          assignedTo: data.assignedTo,
        },
      });

      calendar.render(); // Refresh the calendar view
    })
    .catch(error => console.error('Error:', error));
  };
});
