package basic

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class AkkaHttpWebsockets extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:9001")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Gatling2")
    .wsBaseURL("ws://localhost:9001")

  val scn = scenario("WebSocket")
      .exec(ws("Connect WS").open("/simple"))
      .repeat(3){
       exec(ws("Say Hello WS")
      .sendText("""jello""")
      .check(wsAwait.within(3 second).until(1).regex(".*ollej.*")))
      .pause(10)
  }.exec(ws("Close WS").close)

  setUp(scn.inject(rampUsers(2) over(20 seconds))).protocols(httpConf)

}
