// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';


const xhttp = new XMLHttpRequest();

xhttp.open("GET","./getDashBoard");
xhttp.send();
xhttp.addEventListener("readystatechange", function(){
    if(this.readyState==4 && this.status==200){
      console.log(xhttp.responseText);
      var res = JSON.parse(xhttp.responseText);
      console.log(JSON.stringify(res.charts[0].labels))

      // Bar Chart
      var ctx = document.getElementById("myBarChart");
      var myLineChart = new Chart(ctx, {
        type: 'bar',
        data: {
          labels: [ res.charts[4].labels, res.charts[3].labels, res.charts[2].labels, res.charts[1].labels, res.charts[0].labels],
          datasets: [{
            label: "Revenue",
            backgroundColor: "rgba(53, 133, 74, 1)",
            borderColor: "rgba(53, 133, 74, 1)",
            data: [res.charts[4].data, res.charts[3].data, res.charts[2].data, res.charts[1].data, res.charts[0].data],
          }],
        },
        options: {
          scales: {
            xAxes: [{
              time: {
                unit: 'month'
              },
              gridLines: {
                display: false
              },
              ticks: {
                maxTicksLimit: 6
              }
            }],
            yAxes: [{
              ticks: {
                min: 0,
                max: 1000000,
                maxTicksLimit: 5
              },
              gridLines: {
                display: true
              }
            }],
          },
          legend: {
            display: false
          }
        }
      });

    }
})


let d = new Date();
const year = d.getFullYear(); 
const month = d.getMonth();   
const day = d.getDate();   