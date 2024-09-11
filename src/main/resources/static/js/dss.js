// script.js
document.addEventListener("DOMContentLoaded", function () {
  // Predictive Maintenance Chart
  const predictiveMaintenanceCtx = document
    .getElementById("predictiveMaintenanceChart")
    .getContext("2d");
  const predictiveMaintenanceChart = new Chart(predictiveMaintenanceCtx, {
    type: "line",
    data: {
      labels: ["January", "February", "March", "April", "May", "June", "July"],
      datasets: [
        {
          label: "Failure Probability",
          data: [10, 20, 15, 25, 35, 50, 65],
          borderColor: "#49525c",
          fill: false,
          tension: 0.1,
        },
      ],
    },
    options: {
      scales: {
        y: {
          beginAtZero: true,
          title: {
            display: true,
            text: "Probability (%)",
          },
        },
      },
    },
  });

  // Risk Assessment Chart
  const riskAssessmentCtx = document
    .getElementById("riskAssessmentChart")
    .getContext("2d");
  const riskAssessmentChart = new Chart(riskAssessmentCtx, {
    type: "bar",
    data: {
      labels: ["Server 1", "Router 2", "Switch 3", "Firewall 4", "Server 2"],
      datasets: [
        {
          label: "Risk Level",
          data: [3, 2, 5, 4, 1],
          backgroundColor: [
            "#dc3545",
            "#ffc107",
            "#28a745",
            "#17a2b8",
            "#49525c",
          ],
        },
      ],
    },
    options: {
      scales: {
        y: {
          beginAtZero: true,
          title: {
            display: true,
            text: "Risk Level",
          },
        },
      },
    },
  });
});
