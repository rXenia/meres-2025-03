<?php
function connect() {
    $host = 'localhost';
    $user = 'root';
    $passwd = '';
    $db = 'ingatlan';
    $port = '';
    
    $connection = new mysqli($host, $user, $passwd, $db, $port);
    
    if ($connection->connect_error) {
        die('Csatlakozási hiba: ' . $connection->connect_error);
    }

    return $connection;
}

class Ingatlan{

    static function getAllIngatlan(){
        try{
            $kapcsolat = connect();
            
            header('Content-Type: application/json');
            $sql = 'CALL getAllIngatlan();';
            $adatok = mysqli_query($kapcsolat, $sql);
            
            $ret = [];
            while ($row = $adatok->fetch_assoc()) {
                array_push($ret, $row);
            }

            if($ret){
                http_response_code(200);
                // print_r(json_encode($ret));
                return json_encode($ret);
            }
            else{
                http_response_code(400);
            }
            
            mysqli_close($kapcsolat);
        }
        catch(Exception $ex){
            http_response_code(500);
            print $ex->getMessage();
            return $ex->getMessage();
        }
    }

    public static function createIngatlan($kategoria, $leiras, $hirdetesDatuma, $tehermentes, $ar, $kepUrl){
        try{
            $kapcsolat = connect();
            
            header('Content-Type: application/json');
            $sql = sprintf('CALL createIngatlan(%d, "%s", "%s", %d, %d, "%s");', $kategoria, $leiras, $hirdetesDatuma, $tehermentes, $ar, $kepUrl);

            $adatok = mysqli_query($kapcsolat, $sql);
            mysqli_close($kapcsolat);

            if($adatok){
                $id = $adatok->fetch_column();
                return $id;
            }
            else{
                http_response_code(400);
                return "Hiányos adatok";
            }
            
        }
        catch(Exception $ex){
            return $ex->getMessage();
        }
    }

    public static function deleteIngatlan($id){
        try{
            $kapcsolat = connect();
            
            header('Content-Type: application/json');
            $sql = sprintf('CALL deleteIngatlan(%d);', $id);
            mysqli_query($kapcsolat, $sql);
            mysqli_close($kapcsolat);
            http_response_code(204);
            return "";
        }
        catch(Exception $ex){
            print $ex->getMessage();
            return $ex->getMessage();
        }
    }
}

?>