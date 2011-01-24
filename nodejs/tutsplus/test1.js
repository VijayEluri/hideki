var sys  = require("sys");
var http = require("http");
var handler = function(req, res){
	res.writeHead(200, {"Content-Type": "text/html"});
	res.write("Hello world!");
	res.end();
};
var server = http.createServer(handler);
server.listen(8000);
sys.puts("Server running at http://localhost:8000/");
