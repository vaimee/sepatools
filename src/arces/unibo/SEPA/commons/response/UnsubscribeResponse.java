/* This class represents the response to a unsubscribe request
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

import com.google.gson.JsonPrimitive;

import arces.unibo.SEPA.commons.response.Response;

/**
 * This class represents the response to a SPARQL 1.1 Unsubscribe (see SPARQL 1.1 Subscription Language)
 *
 * The JSON serialization is the following:
 *
 * {"unsubscribed" : "SPUID"}
 *
 * @author Luca Roffia (luca.roffia@unibo.it)
 * @version 0.1
 * */

public class UnsubscribeResponse extends Response {
	
	public UnsubscribeResponse(Integer token, String spuid) {
		super(token);
		
		if (spuid != null) json.add("unsubscribed", new JsonPrimitive(spuid));
	}

	public UnsubscribeResponse(String spuid) {
		super();
		
		if (spuid != null) json.add("unsubscribed", new JsonPrimitive(spuid));
	}
	
	public UnsubscribeResponse() {
		super();
	}

	public String getSpuid() {
		if (json.get("unsubscribed") == null) return "";
		return json.get("unsubscribed").getAsString();
	}
}
