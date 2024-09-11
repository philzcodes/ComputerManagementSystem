// script.js
document.addEventListener("DOMContentLoaded", function () {
  const reportForm = document.getElementById("reportForm");

  reportForm.onsubmit = function (event) {
    event.preventDefault();
    const reportType = document.getElementById("reportType").value;
    const startDate = document.getElementById("startDate").value;
    const endDate = document.getElementById("endDate").value;

    alert(`Generating ${reportType} report from ${startDate} to ${endDate}.`);
    // Implement actual report generation logic here
  };

  // Analytics Chart
  const analyticsCtx = document
    .getElementById("analyticsChart")
    .getContext("2d");
  const analyticsChart = new Chart(analyticsCtx, {
    type: "bar",
    data: {
      labels: ["January", "February", "March", "April", "May", "June"],
      datasets: [
        {
          label: "Downtime (hours)",
          data: [10, 20, 15, 25, 30, 35],
          backgroundColor: "#49525c",
        },
        {
          label: "Maintenance Cost ($)",
          data: [2000, 2500, 2200, 2700, 3000, 3500],
          backgroundColor: "#28a745",
        },
      ],
    },
    options: {
      scales: {
        y: {
          beginAtZero: true,
        },
      },
    },
  });
});
