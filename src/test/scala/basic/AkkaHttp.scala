//package basic
//
//import io.gatling.core.scenario.Simulation
//import io.gatling.core.Predef._
//import io.gatling.http.Predef._
//import scala.concurrent.duration._
//
//
//class AkkaHttp  extends Simulation{
//
//  val httpProtocol = http
//    .baseURL("http://localhost:8080")
//    .inferHtmlResources()
//    .acceptHeader("""text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8""")
//    .acceptEncodingHeader("""gzip, deflate""")
//    .acceptLanguageHeader("""en-US,en;q=0.5""")
//
//
//  val scn = scenario("WebSocket")
//    .exec( http("request_1").get("/provider?gender=M&plan=healthPlanAffiliations_7"))
//    .pause(1)
//    .exec( http("request_1").get("/provider?gender=F&plan=healthPlanAffiliations_4"))
//    .pause(1)
//    .exec( http("request_1").get("/provider?gender=F&plan=healthPlanAffiliations_20"))
//    .pause(1)
//    .exec( http("request_1").get("/provider?gender=F&plan=healthPlanAffiliations_500"))
//    .pause(1)
//    .exec( http("request_1").get("/provider?gender=F&plan=healthPlanAffiliations_500"))
//    .pause(1)
//    .exec( http("request_1").get("/provider?gender=F&plan=healthPlanAffiliations_500"))
//    .pause(1)
//    .exec( http("request_1").get("/provider?gender=F&plan=healthPlanAffiliations_500"))
//    .pause(1)
//    .exec( http("request_1").get("/provider?gender=F&plan=healthPlanAffiliations_500"))
//
//
//  setUp(scn.inject(
//    atOnceUsers(1000)
//  ).protocols(httpProtocol)).throttle(
//      reachRps(100) in (10 seconds),
//      holdFor(1 minute),
//      jumpToRps(200),
//      holdFor(1 minute),
//      jumpToRps(300),
//      holdFor(1 minute),
//      jumpToRps(400),
//      holdFor(1 minute),
//      holdFor(2 hours))
//
//}
