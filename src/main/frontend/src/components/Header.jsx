import React, { Component } from "react";
import logo from "../img/logo.png";
import {
  Image,
  Navbar,
  Button,
  Modal,
  Form,
  InputGroup,
  FormControl,
  Row
} from "react-bootstrap";
import { Link } from "react-router-dom";
import "../App.css";
class Header extends Component {
  constructor(props) {
    super(props);
    this.state = {
      login: false,
      register: false,
      mode: 1
    };
  }

  render() {
    const { login, register, mode } = this.state;
    return (
      <>
        <Navbar bg="dark" variant="dark">
          <Navbar.Brand className="header" href="/">
            <Image alt="" src={logo} width="50" height="50" />
            {"   "}
            Giant Dish
          </Navbar.Brand>
          <Navbar.Collapse />
          <Button onClick={() => this.setState({ mode: mode === 1 ? 2 : 1 })}>
            mode
          </Button>
          {mode === 1 ? (
            <>
              <div className="button1">
                <Button
                  variant="outline-light"
                  onClick={() => this.setState({ login: true })}
                >
                  로그인
                </Button>
              </div>

              <div className="button2">
                <Button
                  variant="outline-light"
                  onClick={() => this.setState({ register: true })}
                >
                  회원가입
                </Button>
              </div>
            </>
          ) : (
            <>
              <div className="button1">
                <Button
                  variant="outline-light"
                  onClick={() => this.setState({ login: true })}
                >
                  로그아웃
                </Button>
              </div>

              <div className="button2">
                <Link to="/myinfo">
                  <Button variant="outline-light">MY 정보</Button>
                </Link>
              </div>
            </>
          )}
        </Navbar>
        <Modal
          show={login}
          onHide={() => this.setState({ login: false })}
          animation={false}
        >
          <Modal.Header closeButton>
            <Modal.Title>로그인</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <Form>
              <Form.Group controlId="formBasicEmail">
                <Form.Label>ID</Form.Label>
                <Form.Control type="email" placeholder="ID" />
              </Form.Group>

              <Form.Group controlId="formBasicPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control type="password" placeholder="Password" />
              </Form.Group>
              <Form.Group controlId="formBasicCheckbox">
                <Form.Check
                  type="switch"
                  id="custom-switch"
                  label="자동 로그인"
                />
              </Form.Group>
            </Form>
          </Modal.Body>
          <Modal.Footer>
            <Button variant="primary" type="submit">
              로그인
            </Button>
            <Button
              variant="secondary"
              onClick={() => this.setState({ login: false })}
            >
              취소
            </Button>
          </Modal.Footer>
        </Modal>
        <Modal
          show={register}
          onHide={() => this.setState({ register: false })}
          animation={false}
        >
          <Modal.Header closeButton>
            <Modal.Title>회원가입<br></br><div className="small">* 항목은 필수입력 항목입니다.</div></Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <label>* 이름</label>
            <InputGroup className="mb-3">
              <FormControl aria-label="ID" aria-describedby="basic-addon2" />
              <InputGroup.Append>
                <Button variant="outline-secondary">중복확인</Button>
              </InputGroup.Append>
            </InputGroup>
            <label>* 이메일 주소</label>
            <InputGroup className="mb-3">
              <FormControl aria-label="ID" aria-describedby="basic-addon2" />
            </InputGroup>
            <label>* 비밀번호 입력</label>
            <InputGroup className="mb-3">
              <FormControl
                type="password"
                aria-label="password"
                aria-describedby="basic-addon2"
              />
              <InputGroup.Append>
                <Button variant="outline-secondary">확인</Button>
              </InputGroup.Append>
            </InputGroup>
            <InputGroup className="mb-3">
              <FormControl
                type="password"
                placeholder="비밀번호 재입력"
                aria-label="password"
                aria-describedby="basic-addon2"
              />

              <InputGroup.Append>
                <Button variant="outline-secondary">확인</Button>
              </InputGroup.Append>
            </InputGroup>
            <label>주소</label>
            <InputGroup className="mb-3">
              <FormControl aria-label="ID" aria-describedby="basic-addon2" />
            </InputGroup>
            <Form.Group controlId="formBasicCheckbox">
    <Form.Check type="checkbox" label="일단넣어놓은 체크박스(나중에 롤 대비)" />
  </Form.Group>
          </Modal.Body>
          <Modal.Footer>
            <Button
              variant="secondary"
              onClick={() => this.setState({ register: false })}
            >
              가입
            </Button>
            <Button
              variant="secondary"
              onClick={() => this.setState({ register: false })}
            >
              취소
            </Button>
          </Modal.Footer>
        </Modal>
      </>
    );
  }
}

export default Header;
