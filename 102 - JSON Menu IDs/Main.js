/* This program reads in a line and then uses JSON.parse to transform
 * the text into a JSON object. We can then search in
 * 			json.menu.items
 * for all of the items and see if each item contains a label. If it does,
 * add it's value to the running total.
 *
 */
var fs  = require("fs");
fs.readFileSync(process.argv[2]).toString().split('\n').forEach(function (line) {
    if (line != "") {
        var json = JSON.parse(line);
        var idTotal = 0;

        json.menu.items.forEach(
            function getSum(item){
                if(item && item.label) idTotal+=item.id;
            }
        );
        
        console.log(idTotal);
    }
});