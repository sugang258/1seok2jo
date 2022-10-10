// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

const cnt = document.getElementById("cnt");
cnt.onclick=function(){
  const xhttp = new XMLHttpRequest();
  xhttp.open("POST","member/deleteMember");
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
  xhttp.send("id="+id_list[i])
  xhttp.addEventListener("readystatechange", function(){
      if(this.readyState==4 && this.status==200){
          console.log(xhttp.responseText);
      }
  })
}

let d = new Date();
const year = d.getFullYear(); 
const month = d.getMonth();   
const day = d.getDate();      
let today = new Date(Date.now()).toLocaleDateString();
let today1=new Date(year, month, day - 1).toLocaleDateString();
let today2=new Date(year, month, day - 2).toLocaleDateString();
let today3=new Date(year, month, day - 3).toLocaleDateString();
let today4=new Date(year, month, day - 4).toLocaleDateString();


// Bar Chart Example
var ctx = document.getElementById("myBarChart");
var myLineChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: [ today4.substring(0,today4.length-1),  today3.substring(0,today3.length-1), today2.substring(0,today2.length-1), today1.substring(0,today1.length-1), today.substring(0,today.length-1)],
    datasets: [{
      label: "Revenue",
      backgroundColor: "rgba(53, 133, 74, 1)",
      borderColor: "rgba(53, 133, 74, 1)",
      data: [4215, 5312, 6251, 7841, 14984],
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
          max: 15000,
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
