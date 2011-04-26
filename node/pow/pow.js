var http = require('http');
var url = require('url');
var host = process.env.VCAP_APP_HOST || 'localhost';
var port = process.env.VCAP_APP_PORT || 3000;

var pow = function(x, n) {
	if(n === 1){
		return x;
	}
	var temp = pow(x, Math.floor(n/2));
	if(n % 2 === 0){
		return temp * temp;
	}
	else{
		return temp * temp * x;
	}
};

http.createServer(function (req, res) {
  	res.writeHead(200, {'Content-Type': 'text/html'});
  	res.write('<html><body>');
  	res.write('<h1>Power function with Node.js</h1>');
	var urlObj = url.parse(req.url, true);
	var uri = urlObj.pathname;  
    if(uri === "/pow") {  
		var query = urlObj.query;
		var base = query.base;
		var exponent = query.exponent;
  		res.write('pow('+base+', '+exponent+') = ' + pow(base, exponent));
 		res.write('<hr/>');
	}
  	res.write('<form method="get" action="/pow">');
 	res.write('<table>');
  	res.write('<tr><td>base</td><td><input type="text" name="base"/></td></tr>');
  	res.write('<tr><td>exponent</td><td><input type="text" name="exponent"/></td></tr>');
 	res.write('</table>');
  	res.write('<input type="submit" value="pow"/>');
  	res.write('</form>');
  	res.end('</body></html>');
}).listen(port, null);

console.log('Server running at http://' + host + ':' + port + '/');
