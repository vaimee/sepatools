/* This class represents a SEPA notification
 * 
 * Author: Luca Roffia (luca.roffia@unibo.it)

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package arces.unibo.SEPA.commons.response;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import arces.unibo.SEPA.commons.SPARQL.ARBindingsResults;

/**
 * This class represents a SPARQL Notification (see SPARQL 1.1 Subscription Language)
 *
 * The JSON serialization looks like:
 *
 * {
 * 		"spuid" : "SPUID" , 
 * 		"sequence" : "SEQUENTIAL NUMBER", 
 * 		"results" : <JSON Notification Results>
 * }
 * 
* @author Luca Roffia (luca.roffia@unibo.it)
* @version 0.1
* */

public class Notification extends Response {

	public Notification(String spuid,ARBindingsResults results,Integer sequence) {
		super();

		if (results != null) json.add("results",results.toJson());
		if (spuid != null) json.add("spuid",new JsonPrimitive(spuid));
		json.add("sequence", new JsonPrimitive(sequence));
	}
	
	public Notification(JsonObject notify) {
		super();

		json = notify;
	}
	
	public String getSPUID() {
		if (json.get("spuid")!=null) return json.get("spuid").getAsString();
		return "";
	}

	public ARBindingsResults getARBindingsResults() {
		if (json.getAsJsonObject("results")!=null) return new ARBindingsResults(json.getAsJsonObject("results"));
		return null;
	}

	public Integer getSequence() {
		return json.get("sequence").getAsInt();
	}

	public boolean toBeNotified() {
		return json.get("results") != null;
	}
}
