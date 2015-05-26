package basic

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class AkkaHttpWebsockets extends Simulation {

  val httpConf = http
    .baseURL("http://54.157.17.66:9001")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Gatling2")
    .wsBaseURL("ws://52.6.139.106:9001")


  val scn = scenario("WebSocket")
    .exec(ws("Connect WS").open("/simple"))
    .pause(55)
    .exec(ws("Say Hello WS 1")
    .sendText("""jello""")
    .check(wsListen.within(30 second).until(1).regex(".*ollej.*")))
    .pause(55)
    .exec(ws("Say Hello WS 2")
    .sendText("""jello""")
    .check(wsListen.within(30 second).until(1).regex(".*ollej.*")))
    .exec(ws("Say Hello WS 3")
    .sendText("""jello""")
    .check(wsListen.within(30 second).until(1).regex(".*ollej.*")))
    .exec(ws("Say Hello WS 4")
    .sendText("""jello""")
    .check(wsListen.within(30 second).until(1).regex(".*ollej.*")))
    .pause(2000)
    .exec(ws("Close WS").close)

  setUp(scn.inject(rampUsers(20000) over(40 minutes))).protocols(httpConf)

}
