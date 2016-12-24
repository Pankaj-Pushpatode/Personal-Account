function validEmail(thefield,therlength,themessage,id1)
{
    var ctr=0;
    var theinput=thefield.value;
    var thelength=theinput.length;
    var goodzip=true;
    if(thelength<therlength)
    {
        goodzip=false;
    }
    if(theinput.indexOf("@")==-1)
    {
        goodzip=false;
    }
    for(var i=0;i<thelength;i++)
    {
        var thechar=theinput.substring(i,i+1);
        if(thechar=="@") {
            ctr++;
        }
    }
    if(ctr>1) {
        goodzip=false;
    }
    if(goodzip==false)
    {
        document.getElementById(id1).innerHTML=themessage
    }
    return goodzip;
}

function validString(thefield,therlength,themessage,id1)
{  
    var theinput=thefield.value;
    var thelength=theinput.length;
    var goodzip=true;
    if(thelength<therlength)
    {
        goodzip=false;
    }
    if(thelength>=therlength)
    {
        for(var i=0;i<thelength;i++)
        {
            var thechar=theinput.substring(i,i+1);
            if(!(thechar>="a" && thechar<="z"
                || thechar>="A" && thechar<="Z" || thechar==" "))
                {
                goodzip=false;
            }
        }
    }
    if(goodzip==false)
    {
        document.getElementById(id1).innerHTML=themessage
    }
    return goodzip;
}


function validNum(thefield,therlength,themessage,id1)
{
    var theinput=thefield.value;
    var thelength=theinput.length;
    var goodzip=true;
    if(thelength<therlength)
    {
        goodzip=false;
    }
    if(thelength>=therlength)
    {
        for(var i=0;i<thelength;i++)
        {
            var thechar=theinput.substring(i,i+1);
            if(!((thechar>="0" && thechar<="9")  || thechar=="."))
            {
                goodzip=false;
            }
        }
    }
    if(goodzip==false)
    {
        document.getElementById(id1).innerHTML=themessage
    }
    return goodzip;
}
 