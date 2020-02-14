<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
let file =null;
function start(){
file = document.getElementById('file').files[0];
console.log(file);

}
</script>
<body>
	asdsd
	<div id="test">
	</div>
	
	<!-- <form id="myForm" > -->
		<input id="file" type="file"/>
<!-- 	</form> -->
	
	<button onclick="start()">ss</button>
	<button onclick="sendMessage()">send</button>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>


<script>
let sock = new SockJS("/ws-stomp");
let client = Stomp.over(sock);
let roomId = '1';
let userId = '${map.userId}';
<c:choose>
	<c:when test="${map.list ne null}">
		let list = ${map.list};	
	</c:when>
	<c:otherwise>
		let list = null;
	</c:otherwise>
</c:choose>
 /* let formData = new FormData();
formData.append("roomId", roomId);
formData.append("sender", userId);
formData.append("message", "hihi");
formData.append("file",file );
 */
	
	function sendMessage(){
		// 웹소켓 서버에 메세지를 보내는 함수
		//원래 여기에서 쓰이는 데이터값들은 클라이언트에서 사용자가 입력한 값을 자바스크립트라든지 이런걸로 가져와서 사용해야하지만 지금은 귀찮으니 그냥 서버에서 준비한 데이터로 사용하겠다.
		/* console.log(file);
		let newfile = {
				 'lastModified'     : file.lastModified,
				   'lastModifiedDate' : file.lastModifiedDate,
				   'name'             : file.name,
				   'size'             : file.size,
				   'type'             : file.type
		} */
		client.send("/pub/chat/message",{},JSON.stringify({roomId: roomId, sender:'userid',message:'hi hello'}));
		//client.send("/pub/chat/message",{},formData);
	}

	function connect(){
		
		
		client.connect({},function(){
			// 이 메소드는 연결에 성공했을 때 실행되는 메소드
			console.log("connected ....");
		
			if(list != null ){
				
				for(i in list){
					// 클라이언트가 해당 url에 구독
					// 저 url과 관련해서 메세지가 전송이 되면 저 subscribe에 의해서 메세지가 클라이언트에 전송이 된다.
					// (이 채팅방에 입장을 한다.)
					client.subscribe("/sub/chat/room/"+list[i] ,function (e){
						//메세지가 도착했을 때 실행되는 메소드
						console.log("!!!!!event", e);
						
					
						
					});	
				}
				
				
								
			}
			

			
			
		});
		
		
	}
	
	// 웹소켓 연결 함수실행
	connect();
	
</script>
	
</body>
</html>
