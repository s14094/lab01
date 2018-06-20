#include "catch.hpp"

#include <rpn.hpp>

//using Catch::Matchers::EndsWith; // see "matchers"
using Catch::Matchers::Contains; // see "matchers"


TEST_CASE("Some test 2")
{
    REQUIRE((10 + 2) == 12);
    rpn testt = rpn();
    REQUIRE(testt.count("14094 10 +") == 14104);
     REQUIRE(testt.count("14094 10 -") == 14084);
     // (1 + 5 - 2) * 3 / 6 
     REQUIRE(testt.count("1 5 + 2 - 3 * 6 /") == 2);
}

TEST_CASE("Error handling")
{
    rpn test = rpn();
    REQUIRE_THROWS_WITH(test.count("10 2 %"), Contains("%"));
}

SCENARIO("Simple scenario")
{
    GIVEN("there are numbers 10 and 20")
    {
        int x = 10, y = 20;
        WHEN("we add them")
        {
            int z = x + y;
            THEN("the result should be 30")
            {
                REQUIRE(z == 30);
            }
        }
    }
}
