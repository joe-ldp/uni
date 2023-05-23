(function()
{
    console.info("Hello JS");

    var startGameBtn = document.getElementById('startGameBtn');
    var playGround = document.querySelector('.playGround');
    var myTimer = document.querySelector('time');
    var myFound = document.getElementById('found');
    var myDifficulty = document.getElementById('difficulty');

    var numDots = 10;
    var dotSize = 20;
    var timePlayed = 0;
    var numFound = 0;
    var difficulty = 1;

    var clockInterval;

    var myAnimation =
    [
        { transform: "scale(0)" },
        { transform: "scale(2)" },
        { transform: "scale(1)" },
    ];

    var myTiming = { duration: 1000, };

    var isTouch = false;
    if('ontouchstart' in window)
    {
        //alert('touch');
        isTouch = true;
    }
    else
    {
        //alert('no touch');
        isTouch = false;
    }


    startGameBtn.addEventListener('click', startGame);

    function startGame(ev)
    {
        console.info("Start game button clicked");
        ev.target.setAttribute('disabled', 'disabled');

        myTimer.removeAttribute('class');
        myFound.removeAttribute('class');
        myDifficulty.removeAttribute('class');
        timePlayed = 0;
        numFound = 0;
        numDots = 10 + difficulty;
        myFound.innerHTML = numFound;
        myDifficulty.innerHTML = difficulty;

        placeDots();
        clockInterval = setInterval(clockCount, 10);
    }

    function placeDots()
    {
        for (var i = 0; i < numDots; i++)
        {
            var newDot = document.createElement('div');
            newDot.setAttribute('class', 'dot');

            var dotTop = Math.random()*(playGround.offsetHeight - dotSize);
            var dotLeft = Math.random()*(playGround.offsetWidth - dotSize);

            var randomDelay = Math.random()*2;
            newDot.style.animationDelay = randomDelay+"s";
            newDot.style.setProperty("--transform-size", 1 + Math.random() * 4);

            var r = Math.floor(Math.random() * 255);
            var g = Math.floor(Math.random() * 255);
            var b = Math.floor(Math.random() * 255);
            newDot.style.setProperty("background", `rgba(${r},${g},${b},1)`);
            
            if(Math.random() * 50 > (numDots - difficulty)*3)
            {
                newDot.setAttribute('class', 'dot repeater');

                if (Math.floor(Math.random() * 100) % 2 == 0)
                {
                    newDot.setAttribute('data-protected', 'true');
                }
                else
                {
                    newDot.setAttribute('data-protected', 'false');
                }
            }

            newDot.style.top = dotTop + 'px';
            newDot.style.left = dotLeft + 'px';

            playGround.appendChild(newDot);
            if (isTouch)
            {
                newDot.addEventListener('touchstart', dotClick);
            }
            else
            {
                newDot.addEventListener('click', dotClick);
            }
        }
    }

    function dotClick(ev)
    {
        console.info(ev.target);
        
        if(ev.target.getAttribute('class') === "dot repeater")
        {
            var dotTop = Math.random()*(playGround.offsetHeight - dotSize);
            var dotLeft = Math.random()*(playGround.offsetWidth - dotSize);

            ev.target.style.top = dotTop + 'px';
            ev.target.style.left = dotLeft + 'px';
            ev.target.setAttribute('class', 'dot');

            ev.target.style.setProperty("--transform-size", 1 + Math.random() * 3);
            ev.target.animate(myAnimation, myTiming);
        }
        else
        {
            if (ev.target.getAttribute('data-protected') == 'true')
            {
                ev.target.setAttribute('data-protected', 'false');
            }
            else
            {
                playGround.removeChild(this);

                numFound++;
                myFound.innerHTML = numFound;

                if(numFound == numDots)
                {
                    endGame();
                }
            }
        }
    }

    function clockCount()
    {
        timePlayed++;

        var seconds = parseInt(timePlayed / 100);
        var centisecond = timePlayed % 100;
        centisecond = centisecond < 10 ? "0" + centisecond : centisecond;
        var displayTime = seconds + ":" + centisecond;

        myTimer.innerHTML = displayTime;
    }

    function endGame()
    {
        clearInterval(clockInterval);
        
        var now = new Date();
        var timestamp = now.getFullYear() + "-" + now.getMonth() + "-" + now.getDate() + "-" + now.getHours() + "-" + now.getMinutes() + "-" + now.getSeconds();
        localStorage.setItem(timestamp, timePlayed + ", " + numFound + ", " + difficulty);
        
        difficulty++;

        myTimer.setAttribute('class', 'finished');
        myFound.setAttribute('class', 'finished');
        myDifficulty.setAttribute('class', 'finished');
        startGameBtn.removeAttribute('disabled');
    }

})();
