/**
 * Created by ajay on 6/3/2015.
 */

var remainingTime = null;
var testCompletePage = window.location.protocol + "//" + window.location.host + "/logout"
$(document).on('ready', function () {
    remainingTime = $("#remainingTime").val();
    var interval = setInterval(testTimer, 1000); // hit function after every 1000ms
});

/**
 * testTimer method will execute after every 1000ms.
 * If the remaining time will complete it will show the Successful test completion pop up ad
 */
function testTimer() {
    if (remainingTime > 0) {
        remainingTime = remainingTime - 1000; // subtract 1 second from the remaining time.
        $('div').html(msToTime(remainingTime)).appendTo('.timerDIv');
    } else {
        alert("time complete");
        window.location.replace(testCompletePage);
    }

}
/**
 * This method converts the milliseconds to HH:MM:SS format.
 * @param time is the milliseconds value.
 * @returns {string} return the time in desired formet.
 */
function msToTime(time) {

    var milliSeconds = time % 1000;
    time = (time - milliSeconds) / 1000;
    var seconds = time % 60;
    time = (time - seconds) / 60;
    var minutes = time % 60;
    var hours = (time - minutes) / 60;
    return hours + ':' + minutes + ':' + seconds;
}

