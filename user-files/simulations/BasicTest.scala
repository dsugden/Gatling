import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BasicTest extends Simulation {

  val httpProtocol = http
    .baseURL("http://google.ca")
    .inferHtmlResources()
    .acceptHeader("""text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8""")
    .acceptEncodingHeader("""gzip, deflate""")
    .acceptLanguageHeader("""en-US,en;q=0.5""")
    .connection("""keep-alive""")

  val scn = scenario("test google")
    .exec(http("GET")
    .get("/?gws_rd=ssl#q=gatling")
    .check(status.is(200)))

  setUp(scn.inject(constantUsersPerSec(5) during(1 seconds) )).protocols(httpProtocol)
}