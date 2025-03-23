<?php
require_once "index.php";

    class Controller{
        public static function requests(){

            $method = $_SERVER['REQUEST_METHOD'];

            header("Content-Type: application/json");
            switch($method) {
                case 'GET':
                    $adatok = json_decode(file_get_contents("php://input"), true);
                    print_r(Ingatlan::getAllIngatlan());
                    break;

                case 'POST':
                    $adatok = json_decode(file_get_contents("php://input"), true);
                    print_r(Ingatlan::createIngatlan($adatok['kategoria'], $adatok['leiras'], $adatok['hirdetesDatuma'], $adatok['tehermentes'], $adatok['ar'], $adatok['kepUrl']));
                    break;

                case 'DELETE':
                    $adatok = json_decode(file_get_contents("php://input"), true);
                    print_r(Ingatlan::deleteIngatlan($_GET['id']));
                    break;

                default:
                    http_response_code(405);
                    echo "Method not allowed";
                    break;
            }
        }
    }

    Controller::requests();
?>