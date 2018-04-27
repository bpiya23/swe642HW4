<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>

<head>
    <style>
        #container {
            border-style: solid;
            height: 1000px;
            width: 1500px;
            margin: auto;
            padding-left: 50px;
            padding-right: 70px;
        }
        
        .top {
            border-style: hidden;
            background-color: #336600;
            padding-top: 10px;
            padding-bottom: 10px;
            margin-left: 50px;
            margin-right: 15px;
        }
        
        .firstcolumn {
            float: left;
            padding-left: 35px;
        }
        
        .secondcolumn {
            float: left;
            padding-left: 35px;
        }
        
        .address {
            float: right;
            font-style: bold;
            margin-bottom: 50px;
            font-size: 1.25em;
        }
        
        .logo {
            float: left;
            height: 130px;
            width: 300px;
        }
        
        .thirdcolumn {
            float: left;
            padding-left: 35px;
        }
    </style>

<script lang="text/javascript">

function fillupData(){
	var chkboxVal = "${studentDetails.campus}";
	var radioVal = "${studentDetails.interest}";
	var monthsel = "${studentDetails.months}";
	var recoVal = "${studentDetails.recommend}";
	
	 var campus =  document.getElementsByName("campus");
     
     for (i = 0; i < campus.length; i++) {
       if (chkboxVal.indexOf(campus[i].value) !=-1) {
          campus[i].checked = 'true';
       }
     }
     
     var interest =  document.getElementsByName("interest");
     for (i = 0; i < interest.length; i++) {
         if (radioVal.indexOf(interest[i].value) !=-1) {
        	 interest[i].checked = 'true';
         }
       }
     
     var months =  document.getElementById("months");
     //alert(months.options);
     for(var i=0; i < months.options.length; i++)
     {
    	 //alert(months.options[i].value + "==" +  monthsel)
       if(months.options[i].value == monthsel) {
    	   months.selectedIndex = i;
         break;
       }
     }
     
     var recommend =  document.getElementById("recommend");
     for(var i=0; i < recommend.options.length; i++)
     {
       if(recommend.options[i].value == recoVal) {
    	   recommend.selectedIndex = i;
         break;
       }
     }
	
}

</script>

</head>

<body onload="fillupData();">

    <div>
        <br/>
<form action="/swe642HW4/SurveyServlet" method="post">
<input type="hidden" name="operation" value="calcMean"/>
        <div class="firstname" style="float:left">

        </div><br/><br/><br/>
        <div style="padding-left:100px;float:left ">
            <h3> Depertment Survey Form:</h3>
            </br>
            
            
            <div class="firstcolumn">
                <br/>
                <strong> Student ID:<span style='color:red'>*</span></strong>
                <br/>
                ${studentDetails.studentID}
               <!--   <input type='text' name='studentID' id='stuid' />-->
                <br/>
                <strong> Name:<span style='color:red'>*</span></strong>
                <br/>
                ${studentDetails.fullname}
               <!--  <input type='text' name='fullname' id='fullname' />-->
                <br/>
                <strong>Street Address:<span style='color:red'>*</span></strong>
                <br/>
				${studentDetails.address}
               <!-- <input type="text " name="address" id="address " />-->
                <br/>



                <strong> Zip Code:<span style='color:red'>*</span></strong>
                <br/>
                ${studentDetails.zip}
              <!--  <input type="text " name="zip " id="zip " onblur="populatecitystate(this.value) " />-->
                <br/>
                <span id="validateZip " class="validator "> </span>
                <br/>
                <strong>City:</strong>
                <br/>
                ${studentDetails.city}
                <!--<input type="text " name="city " id='city' />-->
                <br/>
                <br/>

                <strong>State:</strong>
                <br/>
                ${studentDetails.state}
               <!-- <input type="text " name="state" id='state' />-->
                <br/>
                <br/>
                <strong>Telephone no:<span style='color:red'>*</span></strong>
                <br/>
                ${studentDetails.phone}
               <!-- <input type="text " name="phone " id="phone " />-->
                <br/>
                <br/>
                <strong>email:<span style='color:red'>*</span></strong>
                <br/>
                ${studentDetails.email}
               <!-- <input type="text " name="email " id="email " required/>-->
                <br/>
                <br/>
                <strong>URL:<span style='color:red'>*</span></strong>
                <br/>
                ${studentDetails.url}
               <!--<input type="text " name="url" id="url " />-->
                <br/>
                <br/>
                <strong>Date Of Survey:<span style='color:red'>*</span></strong>
                <br/>
                ${studentDetails.dateofsurvey}
               <!-- <input type="text " name="dateofsurvey" id="dateofsurvey " />-->
            </div>



            <div class="secondcolumn">
                <p>
                    <strong> What you liked most about the campus:<span style='color:red'>*</span></strong></p>

                <input type='checkbox' name='campus' value='students' id="campus " /><label for="thing "></label> students
                <br>
                <input type='checkbox' name='campus' value='location' id="campus " /><label for="thing "></label> location
                <br>
                <input type='checkbox' name='campus' value='campus' id="campus " /><label for="thing "></label> campus
                <br>
                <input type='checkbox' name='campus' value='atmosphere' id="campus " /><label for="thing "></label> atmosphere
                <br>
                <input type='checkbox' name='campus' value='dorm' id="campus " /><label for="thing "></label> dorm rooms
                <br>
                <input type='checkbox' name='campus' value='sports' id="campus " /><label for="thing "></label> sports
                <br/>
                <br/>
                <strong> How you became interested in the University:<span style='color:red'>*</span></strong>
                <br/>


                <input type='radio' name='interest' value='friends' id="interest " /><label for="thing "></label> friends
                <br/>
                <input type='radio' name='interest' value='television' id="interest " /><label for="thing "></label> television
                <br/>
                <input type='radio' name='interest' value='internet' id="interest " /><label for="thing "></label> Internet
                <br/>
                <input type='radio' name='interest' value='other' id="interest " /><label for="thing "></label> other
                <br/>
                <br/>Additional Comments:<span style='color:red'>*</span>
                <br/>
                <br/>
                ${studentDetails.addcomment}
              <!-- <textarea rows="10 " columns="300 " name="addcomment" id="addcomment " /></textarea>-->
            </div>


            <div class="thirdcolumn ">

                <strong>High school Graduation month:<span style='color:red'>*</span></strong>
                <br/>
                 <select name="months" id='months'>
  <option value='0'>January</option>
  <option value='1'>February</option>
   <option value='2'>March</option>
    <option value='3'>April</option>
     <option value='4'>May</option>
      <option value='5'>June</option>
       <option value='6'>July</option>
        <option value='7'>August</option>
         <option value='8'>September</option>
          <option value='9'>October</option>
           <option value='10'>November</option>
            <option value='11'>December</option>
  </select> year: ${studentDetails.year}<!--  <input name="year " id="year ">-->
                <br/>
                <br/>

                <strong>Select movie rating:<span style='color:red'>*</span></strong>
                <br/>
                <br/>

                <strong> User ID:</strong>
                <br/>
                ${studentDetails.userid}
                <!--<input type="text " name="userid" id="userid " />-->
                <br/>


                <br/>
                <strong> Movie ID:</strong>
                <br/>
                ${studentDetails.movieid}
               <!-- <input type="text " name="movieid " id="movieid " />-->
                <br/>
                <strong> Movie Rating:</strong>
                <br/>
                ${studentDetails.movierating}
               <!-- <input type="text " name="movierating" id="movierating" />-->
                <br/>
                <strong>Time Stamp:</strong>
                <br/>
                ${studentDetails.ts}
                <!--<input type="text " name="ts " id="ts " />-->
                <br/>
                <br/>
                <strong>How likely you would recommend George Mason University to prospective students:<span style='color:red'>*</span></strong>
                <br/>
                 <select name="recommend" id="recommend">
  <option value='0'>Very Likely</option>
  <option value='1'>Likely</option>
   <option value='2'>UnLikely</option>
   
</select>
<div id="dbox" title= "pls correct the following erors"> </div>
                <br/>
                <!--  <br/>
                <strong>Data:</strong>
                <br/>-->
                
               <!-- <textarea row="10 " coloum="20 " name="field " id="field " onblur="dataFunction() "></textarea>-->
                <br/>

                <br/>
                <br/>
               <!-- <input type='submit' value='Submit' onclick="survey() " />-->
               <!-- <input type='button' value='reset' onclick="clearvalues() " />-->
                <br/>

</form>

            </div>






















        </div>


</html>