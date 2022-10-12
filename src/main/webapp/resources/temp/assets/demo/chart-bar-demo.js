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
      console.log(res.boardCnt)

      let notAnswer = document.getElementById("notAnswer");
      counterFn(res.notAnswerCnt ,notAnswer, 50);

      //cnt 올리기
      let cntBoard = document.getElementById("cntBoard");
      counterFn(res.boardCnt ,cntBoard, 5);

      let cntMember = document.getElementById("cntMember");
      counterFn(res.memberCnt,cntMember, 100);

      let cntLecture = document.getElementById("cntLecture");
      counterFn(res.lectureCnt,cntLecture, 100);

      let cntLectureIng = document.getElementById("cntLectureIng");
      counterFn(res.lectureIng ,cntLectureIng, 100);

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
      });//barChart끝


    }//응답이 잘오면 실행할 문장 끝
})

function counterFn(maxCnt, elementID, speed) {
  let cnt0 = 0;

  id0 = setInterval(count0Fn, speed);

  function count0Fn() {
    cnt0++;
    if (cnt0 > maxCnt) {
      clearInterval(id0);
    } else {
      elementID.innerText=cnt0;
    }
  }
}

